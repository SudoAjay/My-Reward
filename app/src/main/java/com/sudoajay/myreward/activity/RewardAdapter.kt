package com.sudoajay.myreward.activity

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sudoajay.myreward.R
import com.sudoajay.myreward.activity.database.Reward
import com.sudoajay.myreward.databinding.LayoutRewardAdapterBinding


class RewardAdapter(private var mainActivity: MainActivity) :
    RecyclerView.Adapter<RewardAdapter.MyViewHolder>() {
    var items: List<Reward> = listOf(Reward(0,150),Reward(1, 200))

    class MyViewHolder(
        layoutRewardAdapterBinding: LayoutRewardAdapterBinding
    ) :
        RecyclerView.ViewHolder(layoutRewardAdapterBinding.root) {

        var rewardImageView = layoutRewardAdapterBinding.rewardImageView
        var moneyTextView = layoutRewardAdapterBinding.moneyTextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: LayoutRewardAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_reward_adapter, parent, false
        )
        return MyViewHolder(binding)


    }

    override fun getItemCount(): Int {
        Log.e("RewardAdapater", items.size.toString())
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val reward = items[position]
        Log.e("RewardAdapater", reward.amount.toString() + " --- " + position)
        val colors =
            arrayOf(R.drawable.reward_1, R.drawable.reward_2, R.drawable.reward_3, R.drawable.reward_4)
        holder.rewardImageView.setImageDrawable(
            ContextCompat.getDrawable(
                mainActivity,
                colors.random()
            )
        )
        holder.moneyTextView.text =
            if (reward.amount != 0) mainActivity.getString(R.string.rupee_text) + " " + reward.amount.toString() else mainActivity.getString(
                R.string.better_luck_next_time_text
            )


    }


}

