package ee.cs.ut.example3;

/*
 * Terminology
 * 
 * Variables
 * GLP_CV continuous variable;
 * GLP_IV integer variable;
 * GLP_BV binary variable.
 * 
 * Type Bounds Comment
 * GLP_FR −1 < x < +1 Free (unbounded) variable
 * GLP_LO lb · x < +1 Variable with lower bound
 * GLP_UP −1 < x · ub Variable with upper bound
 * GLP_DB lb · x · ub Double-bounded variable
 * GLP_FX lb = x = ub Fixed variable
 */


import org.gnu.glpk.GLPK;
import org.gnu.glpk.GLPKConstants;
import org.gnu.glpk.SWIGTYPE_p_double;
import org.gnu.glpk.SWIGTYPE_p_int;
import org.gnu.glpk.glp_iocp;
import org.gnu.glpk.glp_prob;
import org.gnu.glpk.glp_smcp;



/**
 * 
 * @author Huber Flores
 *
 */

public class Example3 {
	/*
	 * Maximize z = 5*x1 + 3*x2 
	 * 
	 * subject to:
	 * 
	 * x1 - x2 <= 1
	 * 
	 * 2*x1 + x2 <= 2
	 * 
	 * x1, x2>= 0
	 * 
	 */
	
	public static void main(String[] arg) {
		glp_prob lp;
	    glp_iocp iocp;
	    SWIGTYPE_p_int ind;
	    SWIGTYPE_p_double val;
	    int ret;
	    
	    glp_smcp parm;

    
        lp = GLPK.glp_create_prob();
        System.out.println("Problem created");
        
        GLPK.glp_add_rows(lp, 2);
        
        GLPK.glp_set_row_name(lp, 1, "s1");
        GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_UP, 0.0, 1.0);
        
        GLPK.glp_set_row_name(lp, 2, "s2");
        GLPK.glp_set_row_bnds(lp, 2, GLPKConstants.GLP_UP, 0.0, 2.0);
        
               
        // Define columns
        GLPK.glp_add_cols(lp, 3);
        
        GLPK.glp_set_col_name(lp, 1, "x1");
        GLPK.glp_set_col_bnds(lp, 1, GLPKConstants.GLP_LO, 0.0, 0.0);
        GLPK.glp_set_col_kind(lp, 1, GLPKConstants.GLP_CV);
        
        GLPK.glp_set_col_name(lp, 2, "x2");
        GLPK.glp_set_col_bnds(lp, 2, GLPKConstants.GLP_LO, 0.0, 0.0);
        GLPK.glp_set_col_kind(lp, 2, GLPKConstants.GLP_CV);
        
                
        
        // Allocate memory
        ind = GLPK.new_intArray(3);
        val = GLPK.new_doubleArray(3);

        GLPK.intArray_setitem(ind, 1, 1);
        GLPK.intArray_setitem(ind, 2, 2);
        GLPK.doubleArray_setitem(val, 1, 1);
        GLPK.doubleArray_setitem(val, 2, -1);
        GLPK.glp_set_mat_row(lp, 1, 2, ind, val);
        
        
        GLPK.intArray_setitem(ind, 1, 1);
        GLPK.intArray_setitem(ind, 2, 2);
        GLPK.doubleArray_setitem(val, 1, 2);
        GLPK.doubleArray_setitem(val, 2, 1);
        GLPK.glp_set_mat_row(lp, 2, 2, ind, val);
        
  
        GLPK.delete_doubleArray(val);
        GLPK.delete_intArray(ind);
        
        
        GLPK.glp_set_obj_name(lp, "obj");
        GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MAX);
        //GLPK.glp_set_obj_coef(lp, 0, 0);
        GLPK.glp_set_obj_coef(lp, 1, 5);
        GLPK.glp_set_obj_coef(lp, 2, 3);
        
        
    //  solve model - Integer Optimizer Method
        iocp = new glp_iocp();
        GLPK.glp_init_iocp(iocp);
        iocp.setPresolve(GLPKConstants.GLP_ON);
        ret = GLPK.glp_intopt(lp, iocp);
        
        // Solve model
        /*parm = new glp_smcp();
        GLPK.glp_init_smcp(parm);
        ret = GLPK.glp_simplex(lp, parm);*/

        
        
    //  Retrieve solution
        if (ret == 0) {
          write_mip_solution(lp);
        }
        else {
          System.out.println("The problem could not be solved");
        };
        
        // free memory
        GLPK.glp_delete_prob(lp);
     }  
        
     
	static void write_mip_solution(glp_prob lp)
	  {
	    int i;
	    int n;
	    String name;
	    double val;
	    
	    name = GLPK.glp_get_obj_name(lp);
	    val  = GLPK.glp_mip_obj_val(lp);
	    System.out.print(name);
	    System.out.print(" = ");
	    System.out.println(val);
	    n = GLPK.glp_get_num_cols(lp);
	    for(i=1; i <= n; i++)
	    {
	      name = GLPK.glp_get_col_name(lp, i);
	      val  = GLPK.glp_mip_col_val(lp, i);
	      System.out.print(name);
	      System.out.print(" = ");
	      System.out.println(val);
	    }
	  }

}
