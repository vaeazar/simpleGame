package com.bigin.game.common.constant;

import java.util.Arrays;
import java.util.Optional;

/**
 * 스킬 정보
 * skillName 스킬 명
 * skillMagicPoint 스킬 소비 마나
 * skillDuration 스킬 지속시간
 * skillHasLimit 스킬 상한 여부 상한은 기본 스텟
 * skillIncreaseName 증가 될 스테이터스
 * skillDecreaseName 감소 될 스테이터스
 * skillIncreaseValue 증가 될 값
 * skillDecreaseValue 감소 될 값
 */
public enum Skills {
  HEAL("heal", 10, 0, true, new String[]{"healthPoint"}, new String[]{}, new double[]{0.2}, new double[]{})
  , STEAM("steam", 20, 60, false, new String[]{"damage"}, new String[]{}, new double[]{0.2}, new double[]{})
  , GUARD("guard", 40, 60, false, new String[]{"defend"}, new String[]{}, new double[]{0.3}, new double[]{})
  , ILLUSION("illusion", 40, 60, false, new String[]{"avoid"}, new String[]{}, new double[]{0.3}, new double[]{})
  , ANGER("anger", 40, 60, false, new String[]{"damage"}, new String[]{"defend"}, new double[]{0.5}, new double[]{0.1})
  , INVINCIBLE("invincible", 100, 10, false, new String[]{}, new String[]{}, new double[]{}, new double[]{})
  , RAPID("rapid", 100, 60, false, new String[]{"attackSpeed"}, new String[]{}, new double[]{5}, new double[]{})
  , FRENZY("frenzy", 100, 60, false, new String[]{"damage"}, new String[]{}, new double[]{5}, new double[]{})
  , FAIL("fail", 0, 0, false, new String[]{}, new String[]{}, new double[]{}, new double[]{})
  ;

  private final String skillName;
  private final int skillMagicPoint;
  private final int skillDuration;
  private final boolean skillHasLimit;
  private final String[] skillIncreaseName;
  private final String[] skillDecreaseName;
  private final double[] skillIncreaseValue;
  private final double[] skillDecreaseValue;

  Skills(String skillName, int skillMagicPoint, int skillDuration, boolean skillHasLimit, String[] skillIncreaseName, String[] skillDecreaseName, double[] skillIncreaseValue, double[] skillDecreaseValue){
    this.skillName = skillName;
    this.skillMagicPoint = skillMagicPoint;
    this.skillDuration = skillDuration;
    this.skillHasLimit = skillHasLimit;
    this.skillIncreaseName = skillIncreaseName;
    this.skillDecreaseName = skillDecreaseName;
    this.skillIncreaseValue = skillIncreaseValue;
    this.skillDecreaseValue = skillDecreaseValue;
  }

  public String getSkillName() {
    return skillName;
  }

  public int getSkillDuration() {
    return skillDuration;
  }

  public int getSkillMagicPoint() {
    return skillMagicPoint;
  }

  public boolean getSkillHasLimit() {
    return skillHasLimit;
  }

  public String[] getSkillIncreaseName() {
    return skillIncreaseName;
  }

  public String[] getSkillDecreaseName() {
    return skillDecreaseName;
  }

  public double[] getSkillIncreaseValue() {
    return skillIncreaseValue;
  }

  public double[] getSkillDecreaseValue() {
    return skillDecreaseValue;
  }

  public static int selectMagicPoint(String keys) {
    Optional<Skills> tempSkills = Arrays.stream(Skills.values())
        .filter(status -> status.skillName.equals(keys))
        .findFirst();
    return tempSkills.map(Skills::getSkillMagicPoint).orElse(-1);
  }

  public static int selectDuration(String keys) {
    Optional<Skills> tempSkills = Arrays.stream(Skills.values())
        .filter(status -> status.skillName.equals(keys))
        .findFirst();
    return tempSkills.map(Skills::getSkillDuration).orElse(-1);
  }

  public static Skills selection(String keys) {
    return Arrays.stream(Skills.values())
        .filter(status -> status.skillName.equals(keys))
        .findFirst()
        .orElse(FAIL);
  }
}
