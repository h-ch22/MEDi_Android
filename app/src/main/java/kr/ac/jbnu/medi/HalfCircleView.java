package kr.ac.jbnu.medi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class HalfCircleView extends View {
    private static final float SWEEP_INC = 2;

    private boolean isAlive = false;

    private float width ;
    private float height ;

    private Paint mPaint;
    private RectF mHalfCircle;
    // 시작위치
    private float startPoint = 180;
    private float endPoint = 180;
    // 시간
    private float mSweep ;
    //선 굵기
    private int strokeWidth = 10;
    //색
    private int[] colors = {Color.YELLOW};
    //색 범위
    float[] colorPos = {0.0f, 0.17f, 0.34f, 0.51f, 0.68f, 0.85f, 1.0f};

    public float[] getColorPos() {
        return colorPos;
    }

    public int[] getColors() {
        return colors;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public float getStartPoint() {
        return startPoint;
    }

    public float getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(float endPoint) {
        this.endPoint = endPoint;
    }


    public HalfCircleView(Context context , float width , float height, AttributeSet attr) {
        super(context, attr);

        this.width = width;
        this.height = height;

        //반원 좌표
        mHalfCircle = new RectF((float)(width * 0.1), (float)(height *0.2), (float)(width * 0.9), (float)(height * 1.6));
    }


    /**
     * Draw 시작
     */
    public void startDraw(){

        initData();

        isAlive = true;
        invalidate();
    }

    /**
     * 데이터 초기화
     */
    private void initData(){

        startPoint = getStartPoint();
        endPoint   = getEndPoint();

        //페인트
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(getStrokeWidth());

        int[] colors = getColors();
        float[] color_pos = getColorPos();

        LinearGradient shader = new LinearGradient(0, 0, width, height, colors, color_pos, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
    }

    /**
     * draw 원
     * @param canvas
     * @param oval
     * @param useCenter
     * @param startPoint
     * @param paint
     */
    private void drawArcs(Canvas canvas, RectF oval, boolean useCenter, float startPoint , Paint paint) {
        canvas.drawArc(oval, startPoint, mSweep, useCenter, paint);
    }

    @Override protected void onDraw(Canvas canvas) {

        //배경색
        canvas.drawColor(Color.WHITE);
        //선
        drawArcs(canvas, mHalfCircle, false, getStartPoint(), mPaint);
        //반원만
        mSweep += SWEEP_INC;

        if (mSweep > 180) {
            isAlive = false;
        }
        if (mSweep > endPoint) {
            isAlive = false;
        }

        if(isAlive){
            invalidate();
        }
    }
}
