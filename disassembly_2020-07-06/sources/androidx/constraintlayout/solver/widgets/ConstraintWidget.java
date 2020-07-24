package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintWidgetGroup mBelongingGroup;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    boolean mOptimizerMeasured;
    ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    int[] mResolvedMatchConstraintDefault;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;
    protected int mX;
    protected int mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void resolve() {
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        ResolutionDimension resolutionDimension = this.mResolutionWidth;
        if (resolutionDimension != null) {
            resolutionDimension.reset();
        }
        ResolutionDimension resolutionDimension2 = this.mResolutionHeight;
        if (resolutionDimension2 != null) {
            resolutionDimension2.reset();
        }
        this.mBelongingGroup = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public boolean isFullyResolved() {
        if (this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1) {
            return true;
        }
        return false;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mParent;
     */
    public boolean isRootContainer() {
        ConstraintWidget constraintWidget;
        return (this instanceof ConstraintWidgetContainer) && (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer));
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        if (constraintWidget instanceof WidgetContainer) {
            return (WidgetContainer) constraintWidget;
        }
        return null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawX() {
        return this.mDrawX;
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else {
            i = this.mMatchConstraintMinWidth;
            if (i > 0) {
                this.mWidth = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else {
            i = this.mMatchConstraintMinHeight;
            if (i > 0) {
                this.mHeight = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
        } else if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        }
    }

    public void updateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = (this.mWidth + i) - i;
        this.mDrawHeight = (this.mHeight + i2) - i2;
    }

    public void forceUpdateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = (this.mWidth + i) - i;
        this.mDrawHeight = (this.mHeight + i2) - i2;
    }

    public void setDrawOrigin(int i, int i2) {
        this.mDrawX = i - this.mOffsetX;
        this.mDrawY = i2 - this.mOffsetY;
        this.mX = this.mDrawX;
        this.mY = this.mDrawY;
    }

    public void setDrawX(int i) {
        this.mDrawX = i - this.mOffsetX;
        this.mX = this.mDrawX;
    }

    public void setDrawY(int i) {
        this.mDrawY = i - this.mOffsetY;
        this.mY = this.mDrawY;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mWidth;
        int i3 = this.mMinWidth;
        if (i2 < i3) {
            this.mWidth = i3;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mHeight;
        int i3 = this.mMinHeight;
        if (i2 < i3) {
            this.mHeight = i3;
        }
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    public void setDimensionRatio(String str) {
        float f;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i2);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
                if (f > 0.0f) {
                    this.mDimensionRatio = f;
                    this.mDimensionRatioSide = i;
                    return;
                }
                return;
            }
        } else {
            String substring3 = str.substring(i2, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f = i == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        if (f > 0.0f) {
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        f = 0.0f;
        if (f > 0.0f) {
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mWidth;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
        this.mHeight = i2;
        int i5 = this.mHeight;
        int i6 = this.mMinHeight;
        if (i5 < i6) {
            this.mHeight = i6;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED || i7 >= (i5 = this.mWidth)) {
            i5 = i7;
        }
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED || i8 >= (i6 = this.mHeight)) {
            i6 = i8;
        }
        this.mWidth = i5;
        this.mHeight = i6;
        int i9 = this.mHeight;
        int i10 = this.mMinHeight;
        if (i9 < i10) {
            this.mHeight = i10;
        }
        int i11 = this.mWidth;
        int i12 = this.mMinWidth;
        if (i11 < i12) {
            this.mWidth = i12;
        }
        this.mOptimizerMeasured = true;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
        this.mOptimizerMeasured = true;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        this.mWidth = i2 - i;
        int i3 = this.mWidth;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        this.mHeight = i2 - i;
        int i3 = this.mHeight;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength, int i2) {
        boolean z;
        ConstraintAnchor.Type type3 = type;
        ConstraintWidget constraintWidget2 = constraintWidget;
        ConstraintAnchor.Type type4 = type2;
        int i3 = i2;
        int i4 = 0;
        if (type3 == ConstraintAnchor.Type.CENTER) {
            if (type4 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    ConstraintWidget constraintWidget3 = constraintWidget;
                    ConstraintAnchor.Strength strength2 = strength;
                    int i5 = i2;
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget3, ConstraintAnchor.Type.LEFT, 0, strength2, i5);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget3, ConstraintAnchor.Type.RIGHT, 0, strength2, i5);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    ConstraintWidget constraintWidget4 = constraintWidget;
                    ConstraintAnchor.Strength strength3 = strength;
                    int i6 = i2;
                    connect(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.TOP, 0, strength3, i6);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget4, ConstraintAnchor.Type.BOTTOM, 0, strength3, i6);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER), 0, i3);
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, i3);
                } else if (z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, i3);
                }
            } else if (type4 == ConstraintAnchor.Type.LEFT || type4 == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0, strength, i2);
                try {
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0, strength, i2);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
                } catch (Throwable th) {
                    throw th;
                }
            } else if (type4 == ConstraintAnchor.Type.TOP || type4 == ConstraintAnchor.Type.BOTTOM) {
                ConstraintWidget constraintWidget5 = constraintWidget;
                ConstraintAnchor.Type type5 = type2;
                ConstraintAnchor.Strength strength4 = strength;
                int i7 = i2;
                connect(ConstraintAnchor.Type.TOP, constraintWidget5, type5, 0, strength4, i7);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget5, type5, 0, strength4, i7);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
            }
        } else if (type3 == ConstraintAnchor.Type.CENTER_X && (type4 == ConstraintAnchor.Type.LEFT || type4 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0, i3);
            anchor7.connect(anchor6, 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0, i3);
        } else if (type3 == ConstraintAnchor.Type.CENTER_Y && (type4 == ConstraintAnchor.Type.TOP || type4 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0, i3);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0, i3);
        } else if (type3 == ConstraintAnchor.Type.CENTER_X && type4 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), 0, i3);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0, i3);
        } else if (type3 == ConstraintAnchor.Type.CENTER_Y && type4 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP), 0, i3);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0, i3);
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type3 == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                } else {
                    if (type3 == ConstraintAnchor.Type.TOP || type3 == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                        if (anchor13 != null) {
                            anchor13.reset();
                        }
                        ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor14.getTarget() != anchor10) {
                            anchor14.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                        if (anchor15.isConnected()) {
                            opposite.reset();
                            anchor15.reset();
                        }
                    } else if (type3 == ConstraintAnchor.Type.LEFT || type3 == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor16.getTarget() != anchor10) {
                            anchor16.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                        if (anchor17.isConnected()) {
                            opposite2.reset();
                            anchor17.reset();
                        }
                    }
                    i4 = i;
                }
                anchor9.connect(anchor10, i4, strength, i3);
                anchor10.getOwner().connectedTo(anchor9.getOwner());
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (!(this instanceof ConstraintWidgetContainer)) {
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getWidth() > getMinWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
            if (getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
                return;
            }
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = this.mAnchors.get(i2);
                if (i == constraintAnchor.getConnectionCreator()) {
                    if (constraintAnchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            if (constraintAnchor != constraintAnchorArr[i2]) {
                int i3 = i2 + 1;
                return constraintAnchorArr[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3];
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x024e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01a7  */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        boolean z5;
        int i3;
        int i4;
        SolverVariable solverVariable;
        boolean z6;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        boolean z7;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        boolean z8;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget;
        int i5;
        boolean z9;
        boolean z10;
        LinearSystem linearSystem3 = linearSystem;
        SolverVariable createObjectVariable = linearSystem3.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem3.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem3.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem3.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem3.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget2 = this.mParent;
        if (constraintWidget2 != null) {
            z4 = constraintWidget2 != null && constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget3 = this.mParent;
            boolean z11 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                z9 = true;
            } else {
                z9 = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                z10 = true;
            } else {
                z10 = isInVerticalChain();
            }
            if (z4 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (z11 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z3 = z11;
            z2 = z9;
            z = z10;
        } else {
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        int i6 = this.mWidth;
        int i7 = this.mMinWidth;
        if (i6 < i7) {
            i6 = i7;
        }
        int i8 = this.mHeight;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            i8 = i9;
        }
        boolean z12 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z13 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i10 = this.mMatchConstraintDefaultWidth;
        int i11 = this.mMatchConstraintDefaultHeight;
        if (f <= 0.0f || this.mVisibility == 8) {
            solverVariable = createObjectVariable5;
            i4 = i10;
            i2 = i6;
            i = i8;
            i3 = i11;
        } else {
            solverVariable = createObjectVariable5;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i10 == 0) {
                i10 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i11 == 0) {
                i11 = 3;
            }
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i10 == 3 && i11 == 3) {
                setupDimensionRatio(z4, z3, z12, z13);
            } else if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i10 == 3) {
                this.mResolvedDimensionRatioSide = 0;
                DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[1];
                DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
                i2 = (int) (this.mResolvedDimensionRatio * ((float) this.mHeight));
                if (dimensionBehaviour != dimensionBehaviour2) {
                    i = i8;
                    i3 = i11;
                    i4 = 4;
                } else {
                    i4 = i10;
                    i = i8;
                    i3 = i11;
                    z5 = true;
                    int[] iArr = this.mResolvedMatchConstraintDefault;
                    iArr[0] = i4;
                    iArr[1] = i3;
                    if (!z5) {
                    }
                    z6 = false;
                    if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || (this instanceof ConstraintWidgetContainer)) {
                    }
                    boolean z14 = !this.mCenter.isConnected();
                    if (this.mHorizontalResolution != 2) {
                    }
                    if (this.mVerticalResolution != 2) {
                    }
                }
            } else if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i11 == 3) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
                DimensionBehaviour dimensionBehaviour3 = this.mListDimensionBehaviors[0];
                DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
                i = (int) (this.mResolvedDimensionRatio * ((float) this.mWidth));
                i4 = i10;
                i2 = i6;
                if (dimensionBehaviour3 != dimensionBehaviour4) {
                    i3 = 4;
                }
                i3 = i11;
                z5 = true;
                int[] iArr2 = this.mResolvedMatchConstraintDefault;
                iArr2[0] = i4;
                iArr2[1] = i3;
                if (!z5) {
                    int i12 = this.mResolvedDimensionRatioSide;
                    if (i12 == 0 || i12 == -1) {
                        z6 = true;
                        boolean z15 = this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                        boolean z142 = !this.mCenter.isConnected();
                        if (this.mHorizontalResolution != 2) {
                            ConstraintWidget constraintWidget4 = this.mParent;
                            SolverVariable createObjectVariable6 = constraintWidget4 != null ? linearSystem3.createObjectVariable(constraintWidget4.mRight) : null;
                            ConstraintWidget constraintWidget5 = this.mParent;
                            z7 = z3;
                            solverVariable3 = solverVariable;
                            solverVariable5 = createObjectVariable4;
                            solverVariable2 = createObjectVariable3;
                            boolean z16 = z15;
                            solverVariable4 = createObjectVariable2;
                            applyConstraints(linearSystem, z4, constraintWidget5 != null ? linearSystem3.createObjectVariable(constraintWidget5.mLeft) : null, createObjectVariable6, this.mListDimensionBehaviors[0], z16, this.mLeft, this.mRight, this.mX, i2, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z2, i4, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z142);
                        } else {
                            solverVariable2 = createObjectVariable3;
                            solverVariable4 = createObjectVariable2;
                            z7 = z3;
                            solverVariable3 = solverVariable;
                            solverVariable5 = createObjectVariable4;
                        }
                        if (this.mVerticalResolution != 2) {
                            boolean z17 = this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                            boolean z18 = z5 && ((i5 = this.mResolvedDimensionRatioSide) == 1 || i5 == -1);
                            if (this.mBaselineDistance <= 0) {
                                linearSystem2 = linearSystem;
                            } else if (this.mBaseline.getResolutionNode().state == 1) {
                                linearSystem2 = linearSystem;
                                this.mBaseline.getResolutionNode().addResolvedValue(linearSystem2);
                            } else {
                                linearSystem2 = linearSystem;
                                SolverVariable solverVariable7 = solverVariable3;
                                solverVariable6 = solverVariable2;
                                linearSystem2.addEquality(solverVariable7, solverVariable6, getBaselineDistance(), 6);
                                if (this.mBaseline.mTarget != null) {
                                    linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                                    z8 = false;
                                    ConstraintWidget constraintWidget6 = this.mParent;
                                    SolverVariable createObjectVariable7 = constraintWidget6 != null ? linearSystem2.createObjectVariable(constraintWidget6.mBottom) : null;
                                    ConstraintWidget constraintWidget7 = this.mParent;
                                    SolverVariable solverVariable8 = solverVariable6;
                                    applyConstraints(linearSystem, z7, constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z17, this.mTop, this.mBottom, this.mY, i, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z18, z, i3, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                                    if (z5) {
                                        constraintWidget = this;
                                        if (constraintWidget.mResolvedDimensionRatioSide == 1) {
                                            linearSystem.addRatio(solverVariable5, solverVariable8, solverVariable4, createObjectVariable, constraintWidget.mResolvedDimensionRatio, 6);
                                        } else {
                                            linearSystem.addRatio(solverVariable4, createObjectVariable, solverVariable5, solverVariable8, constraintWidget.mResolvedDimensionRatio, 6);
                                        }
                                    } else {
                                        constraintWidget = this;
                                    }
                                    if (constraintWidget.mCenter.isConnected()) {
                                        linearSystem.addCenterPoint(constraintWidget, constraintWidget.mCenter.getTarget().getOwner(), (float) Math.toRadians((double) (constraintWidget.mCircleConstraintAngle + 90.0f)), constraintWidget.mCenter.getMargin());
                                        return;
                                    }
                                    return;
                                }
                                z8 = z142;
                                ConstraintWidget constraintWidget62 = this.mParent;
                                if (constraintWidget62 != null) {
                                }
                                ConstraintWidget constraintWidget72 = this.mParent;
                                SolverVariable solverVariable82 = solverVariable6;
                                applyConstraints(linearSystem, z7, constraintWidget72 != null ? linearSystem2.createObjectVariable(constraintWidget72.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z17, this.mTop, this.mBottom, this.mY, i, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z18, z, i3, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                                if (z5) {
                                }
                                if (constraintWidget.mCenter.isConnected()) {
                                }
                            }
                            solverVariable6 = solverVariable2;
                            z8 = z142;
                            ConstraintWidget constraintWidget622 = this.mParent;
                            if (constraintWidget622 != null) {
                            }
                            ConstraintWidget constraintWidget722 = this.mParent;
                            SolverVariable solverVariable822 = solverVariable6;
                            applyConstraints(linearSystem, z7, constraintWidget722 != null ? linearSystem2.createObjectVariable(constraintWidget722.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z17, this.mTop, this.mBottom, this.mY, i, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z18, z, i3, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                            if (z5) {
                            }
                            if (constraintWidget.mCenter.isConnected()) {
                            }
                        } else {
                            return;
                        }
                    }
                }
                z6 = false;
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || (this instanceof ConstraintWidgetContainer)) {
                }
                boolean z1422 = !this.mCenter.isConnected();
                if (this.mHorizontalResolution != 2) {
                }
                if (this.mVerticalResolution != 2) {
                }
            }
            i4 = i10;
            i2 = i6;
            i = i8;
            i3 = i11;
            z5 = true;
            int[] iArr22 = this.mResolvedMatchConstraintDefault;
            iArr22[0] = i4;
            iArr22[1] = i3;
            if (!z5) {
            }
            z6 = false;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || (this instanceof ConstraintWidgetContainer)) {
            }
            boolean z14222 = !this.mCenter.isConnected();
            if (this.mHorizontalResolution != 2) {
            }
            if (this.mVerticalResolution != 2) {
            }
        }
        z5 = false;
        int[] iArr222 = this.mResolvedMatchConstraintDefault;
        iArr222[0] = i4;
        iArr222[1] = i3;
        if (!z5) {
        }
        z6 = false;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || (this instanceof ConstraintWidgetContainer)) {
        }
        boolean z142222 = !this.mCenter.isConnected();
        if (this.mHorizontalResolution != 2) {
        }
        if (this.mVerticalResolution != 2) {
        }
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:154:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d7 A[ADDED_TO_REGION] */
    private void applyConstraints(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        boolean z6;
        int i8;
        int i9;
        int i10;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        SolverVariable solverVariable5;
        boolean z7;
        int i18;
        SolverVariable solverVariable6;
        boolean z8;
        boolean z9;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        int i19;
        int i20;
        boolean z10;
        SolverVariable solverVariable9;
        boolean z11;
        boolean z12;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z13;
        boolean z14;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        LinearSystem linearSystem2 = linearSystem;
        SolverVariable solverVariable12 = solverVariable;
        SolverVariable solverVariable13 = solverVariable2;
        int i25 = i3;
        int i26 = i4;
        SolverVariable createObjectVariable = linearSystem2.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem2.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem2.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor2.getTarget());
        if (linearSystem2.graphOptimizer && constraintAnchor.getResolutionNode().state == 1 && constraintAnchor2.getResolutionNode().state == 1) {
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().resolvedWidgets++;
            }
            constraintAnchor.getResolutionNode().addResolvedValue(linearSystem2);
            constraintAnchor2.getResolutionNode().addResolvedValue(linearSystem2);
            if (!z4 && z) {
                linearSystem2.addGreaterThan(solverVariable13, createObjectVariable2, 0, 6);
                return;
            }
            return;
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i27 = isConnected ? 1 : 0;
        if (isConnected2) {
            i27++;
        }
        if (isConnected3) {
            i27++;
        }
        int i28 = i27;
        int i29 = z3 ? 3 : i5;
        int i30 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        boolean z15 = (i30 == 1 || i30 == 2 || i30 == 3 || i30 != 4 || i29 == 4) ? false : true;
        if (this.mVisibility == 8) {
            i8 = 0;
            z6 = false;
        } else {
            z6 = z15;
            i8 = i2;
        }
        if (z5) {
            if (!isConnected && !isConnected2 && !isConnected3) {
                linearSystem2.addEquality(createObjectVariable, i);
            } else if (isConnected && !isConnected2) {
                i9 = 6;
                linearSystem2.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 6);
                if (z6) {
                    if (z2) {
                        linearSystem2.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
                        if (i25 > 0) {
                            linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, i25, 6);
                        }
                        if (i26 < Integer.MAX_VALUE) {
                            linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i26, 6);
                        }
                    } else {
                        linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, i9);
                    }
                    i11 = i7;
                    i10 = i29;
                    i14 = i28;
                    solverVariable3 = createObjectVariable4;
                    solverVariable4 = createObjectVariable3;
                    i13 = 0;
                    i12 = i6;
                } else {
                    int i31 = i6;
                    if (i31 == -2) {
                        i11 = i7;
                        i22 = i8;
                    } else {
                        i22 = i31;
                        i11 = i7;
                    }
                    if (i11 == -2) {
                        i11 = i8;
                    }
                    if (i22 > 0) {
                        linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, i22, 6);
                        i8 = Math.max(i8, i22);
                    }
                    if (i11 > 0) {
                        linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i11, 6);
                        i8 = Math.min(i8, i11);
                    }
                    if (i29 != 1) {
                        z14 = z6;
                        if (i29 == 2) {
                            if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                                solverVariable10 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                solverVariable11 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                            } else {
                                solverVariable10 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                solverVariable11 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                            }
                            SolverVariable solverVariable14 = solverVariable10;
                            i10 = i29;
                            solverVariable4 = createObjectVariable3;
                            i24 = i8;
                            i14 = i28;
                            i13 = 0;
                            i23 = i22;
                            solverVariable3 = createObjectVariable4;
                            linearSystem2.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable2, createObjectVariable, solverVariable11, solverVariable14, f2));
                            z13 = false;
                            if (z13) {
                            }
                            i12 = i23;
                            z6 = z13;
                        }
                    } else if (z) {
                        linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, 6);
                        i10 = i29;
                        i14 = i28;
                        solverVariable3 = createObjectVariable4;
                        solverVariable4 = createObjectVariable3;
                        z14 = z6;
                        i13 = 0;
                        i24 = i8;
                        i23 = i22;
                        z13 = z14;
                        if (z13 || i14 == 2 || z3) {
                            i12 = i23;
                            z6 = z13;
                        } else {
                            int max = Math.max(i23, i24);
                            if (i11 > 0) {
                                max = Math.min(i11, max);
                            }
                            linearSystem2.addEquality(createObjectVariable2, createObjectVariable, max, 6);
                            i12 = i23;
                            z6 = false;
                        }
                    } else if (z4) {
                        z14 = z6;
                        linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, 4);
                    } else {
                        z14 = z6;
                        linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, 1);
                    }
                    i10 = i29;
                    i14 = i28;
                    i23 = i22;
                    solverVariable3 = createObjectVariable4;
                    solverVariable4 = createObjectVariable3;
                    i13 = 0;
                    i24 = i8;
                    z13 = z14;
                    if (z13) {
                    }
                    i12 = i23;
                    z6 = z13;
                }
                if (z5 || z4) {
                    i15 = i14;
                    SolverVariable solverVariable15 = createObjectVariable2;
                    SolverVariable solverVariable16 = solverVariable12;
                    SolverVariable solverVariable17 = solverVariable13;
                    if (i15 < 2 && z) {
                        linearSystem2.addGreaterThan(createObjectVariable, solverVariable16, 0, 6);
                        linearSystem2.addGreaterThan(solverVariable17, solverVariable15, 0, 6);
                        return;
                    }
                }
                if (isConnected || isConnected2 || isConnected3) {
                    if (!isConnected || isConnected2) {
                        if (isConnected || !isConnected2) {
                            SolverVariable solverVariable18 = solverVariable3;
                            if (isConnected && isConnected2) {
                                if (z6) {
                                    if (z && i3 == 0) {
                                        linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 6);
                                    }
                                    if (i10 == 0) {
                                        if (i11 > 0 || i12 > 0) {
                                            i21 = 4;
                                            z12 = true;
                                        } else {
                                            i21 = 6;
                                            z12 = false;
                                        }
                                        solverVariable6 = solverVariable4;
                                        linearSystem2.addEquality(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), i21);
                                        linearSystem2.addEquality(createObjectVariable2, solverVariable18, -constraintAnchor2.getMargin(), i21);
                                        z8 = i11 > 0 || i12 > 0;
                                        z7 = z12;
                                        i18 = 5;
                                    } else {
                                        int i32 = i10;
                                        solverVariable6 = solverVariable4;
                                        if (i32 == 1) {
                                            z8 = true;
                                            i18 = 6;
                                            z7 = true;
                                        } else if (i32 == 3) {
                                            int i33 = (z3 || this.mResolvedDimensionRatioSide == -1 || i11 > 0) ? 4 : 6;
                                            linearSystem2.addEquality(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), i33);
                                            linearSystem2.addEquality(createObjectVariable2, solverVariable18, -constraintAnchor2.getMargin(), i33);
                                            z8 = true;
                                            i18 = 5;
                                            z7 = true;
                                            if (z8) {
                                                z9 = true;
                                                solverVariable7 = solverVariable18;
                                                solverVariable9 = solverVariable6;
                                                solverVariable8 = createObjectVariable2;
                                                linearSystem.addCentering(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), f, solverVariable18, createObjectVariable2, constraintAnchor2.getMargin(), i18);
                                                boolean z16 = constraintAnchor.mTarget.mOwner instanceof Barrier;
                                                boolean z17 = constraintAnchor2.mTarget.mOwner instanceof Barrier;
                                                if (z16 && !z17) {
                                                    z9 = z;
                                                    z10 = true;
                                                    i20 = 5;
                                                    i19 = 6;
                                                    if (z7) {
                                                    }
                                                    linearSystem2.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i20);
                                                    linearSystem2.addLowerThan(solverVariable8, solverVariable7, -constraintAnchor2.getMargin(), i19);
                                                    if (z) {
                                                    }
                                                } else if (!z16 && z17) {
                                                    z10 = z;
                                                    i20 = 6;
                                                    i19 = 5;
                                                    if (z7) {
                                                        i20 = 6;
                                                        i19 = 6;
                                                    }
                                                    if ((!z6 && z9) || z7) {
                                                        linearSystem2.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i20);
                                                    }
                                                    if ((!z6 && z10) || z7) {
                                                        linearSystem2.addLowerThan(solverVariable8, solverVariable7, -constraintAnchor2.getMargin(), i19);
                                                    }
                                                    if (z) {
                                                        solverVariable5 = solverVariable8;
                                                        i17 = 6;
                                                        i16 = 0;
                                                        linearSystem2.addGreaterThan(createObjectVariable, solverVariable, 0, 6);
                                                        if (z) {
                                                            linearSystem2.addGreaterThan(solverVariable2, solverVariable5, i16, i17);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    solverVariable5 = solverVariable8;
                                                    i17 = 6;
                                                    i16 = 0;
                                                    if (z) {
                                                    }
                                                }
                                            } else {
                                                ConstraintAnchor constraintAnchor3 = constraintAnchor;
                                                ConstraintAnchor constraintAnchor4 = constraintAnchor2;
                                                solverVariable9 = solverVariable6;
                                                solverVariable7 = solverVariable18;
                                                solverVariable8 = createObjectVariable2;
                                            }
                                            z10 = z;
                                            z9 = z10;
                                            i20 = 5;
                                            i19 = 5;
                                            if (z7) {
                                            }
                                            linearSystem2.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i20);
                                            linearSystem2.addLowerThan(solverVariable8, solverVariable7, -constraintAnchor2.getMargin(), i19);
                                            if (z) {
                                            }
                                        } else {
                                            z11 = false;
                                        }
                                    }
                                    if (z8) {
                                    }
                                    z10 = z;
                                    z9 = z10;
                                    i20 = 5;
                                    i19 = 5;
                                    if (z7) {
                                    }
                                    linearSystem2.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i20);
                                    linearSystem2.addLowerThan(solverVariable8, solverVariable7, -constraintAnchor2.getMargin(), i19);
                                    if (z) {
                                    }
                                } else {
                                    solverVariable6 = solverVariable4;
                                    z11 = true;
                                }
                                i18 = 5;
                                z7 = false;
                                if (z8) {
                                }
                                z10 = z;
                                z9 = z10;
                                i20 = 5;
                                i19 = 5;
                                if (z7) {
                                }
                                linearSystem2.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i20);
                                linearSystem2.addLowerThan(solverVariable8, solverVariable7, -constraintAnchor2.getMargin(), i19);
                                if (z) {
                                }
                            }
                        } else {
                            linearSystem2.addEquality(createObjectVariable2, solverVariable3, -constraintAnchor2.getMargin(), 6);
                            if (z) {
                                linearSystem2.addGreaterThan(createObjectVariable, solverVariable12, i13, 5);
                            }
                        }
                    } else if (z) {
                        linearSystem2.addGreaterThan(solverVariable13, createObjectVariable2, i13, 5);
                    }
                } else if (z) {
                    linearSystem2.addGreaterThan(solverVariable13, createObjectVariable2, i13, 5);
                }
                solverVariable5 = createObjectVariable2;
                i17 = 6;
                i16 = 0;
                if (z) {
                }
            }
        }
        i9 = 6;
        if (z6) {
        }
        if (z5) {
        }
        i15 = i14;
        SolverVariable solverVariable152 = createObjectVariable2;
        SolverVariable solverVariable162 = solverVariable12;
        SolverVariable solverVariable172 = solverVariable13;
        if (i15 < 2) {
        }
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = new int[DimensionBehaviour.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        static {
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }
}