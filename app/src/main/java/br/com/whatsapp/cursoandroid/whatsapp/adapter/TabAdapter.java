package br.com.whatsapp.cursoandroid.whatsapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.whatsapp.cursoandroid.whatsapp.fragment.ContatosFragment;
import br.com.whatsapp.cursoandroid.whatsapp.fragment.ConversasFragment;

/**
 * Created by Kildare Silveira on 15/10/2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] tituloAbas = {"CONVERSAS", "CONTATOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragmento = null;

        switch (position) {
            case 0:
                fragmento = new ConversasFragment();
                break;
            case 1:
                fragmento = new ContatosFragment();
                break;
        }

        return fragmento;
    }

    @Override
    public int getCount() {
        return tituloAbas.length;
    }

    public CharSequence getPageTitle(int position){
        return tituloAbas[position];
    }
}
