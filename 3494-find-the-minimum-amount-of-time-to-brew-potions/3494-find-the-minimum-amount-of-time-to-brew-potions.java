class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long sumSkill = 0;
        for (int s : skill) sumSkill += s;

        // “prevWizardDone” = finish time of last wizard for previous potion
        long prevWizardDone = sumSkill * (long) mana[0];

        // process from potion 1 to m-1
        for (int j = 1; j < m; j++) {
            long prevPotionDone = prevWizardDone;

            // for wizard indices from n-2 down to 0
            for (int i = n - 2; i >= 0; i--) {
                // remove contribution of wizard (i+1) on previous potion j-1
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];

                // Decide whether current wizard i should start as soon as previous,
                // or must wait (to align with pipeline constraints)
                long option1 = prevPotionDone;
                long option2 = prevWizardDone - (long) skill[i] * mana[j];
                prevWizardDone = Math.max(option1, option2);
            }

            // then add full processing time of all wizards for potion j
            prevWizardDone += sumSkill * (long) mana[j];
        }

        return prevWizardDone;
    }
}