package main.common;

/**
 * 2-dimensional vector
 */
public class V2d implements java.io.Serializable {

    public double x,y;
    
    public V2d(double x,double y){
        this.x=x;
        this.y=y;
    }

    public V2d(P2d to, P2d from){
        this.x = to.getX() - from.getX();
        this.y = to.getY() - from.getY();
    }

    public V2d sum(V2d v){
        return new V2d(x+v.x,y+v.y);
    }

    public double module(){
        return (double)Math.sqrt(x*x+y*y);
    }

    public V2d getNormalized(){
        double module=(double)Math.sqrt(x*x+y*y);
        return new V2d(x/module,y/module);
    }

    public V2d mul(double fact){
        return new V2d(x*fact,y*fact);
    }

    public String toString(){
        return "V2d("+x+","+y+")";
    }
}
