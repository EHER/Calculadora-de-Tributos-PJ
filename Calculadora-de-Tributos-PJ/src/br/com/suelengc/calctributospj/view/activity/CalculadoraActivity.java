package br.com.suelengc.calctributospj.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorBrutoFragment;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorPorHoraFragment;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class CalculadoraActivity extends SherlockFragmentActivity {
	
	public static final String EXTRA_FORMATO_TELA = "1";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        String tipoBaseCalculo = getIntent().getStringExtra(EXTRA_FORMATO_TELA);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        SherlockFragment myFragment;
        
        if (tipoBaseCalculo.equals(TipoBaseCalculo.VALOR_BRUTO.toString())) {
        	setTitle("C�lculo Valor Bruto");
        	myFragment = new EntradaDadosCalculoValorBrutoFragment();
        	ft.replace(R.id_calc.dadosEntradaCalculo, myFragment);
        	
        }else {
        	setTitle("C�lculo Valor/Hora");
        	myFragment = new EntradaDadosCalculoValorPorHoraFragment();
        	ft.replace(R.id_calc.dadosEntradaCalculo, myFragment);
        }
        ft.commit();        
        
        GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
	}
}