/*
 * Vanessa-Usher
 * Copyright (C) 2019-2021 SilverBulleters, LLC - All Rights Reserved.
 * Unauthorized copying of this file in any way is strictly prohibited.
 * Proprietary and confidential.
 */
package org.silverbulleters.usher.config

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.silverbulleters.usher.UsherConstant
import org.silverbulleters.usher.config.additional.InfoBase
import org.silverbulleters.usher.config.additional.NotificationOptional
import org.silverbulleters.usher.config.stage.BddOptional
import org.silverbulleters.usher.config.stage.BuildOptional
import org.silverbulleters.usher.config.stage.EdtTransformOptional
import org.silverbulleters.usher.config.stage.GitsyncOptional
import org.silverbulleters.usher.config.stage.PrepareBaseOptional
import org.silverbulleters.usher.config.stage.SmokeOptional
import org.silverbulleters.usher.config.stage.SonarQubeOptional
import org.silverbulleters.usher.config.stage.SyntaxCheckOptional
import org.silverbulleters.usher.config.stage.TddOptional

@JsonIgnoreProperties(ignoreUnknown = true)
class PipelineConfiguration implements Serializable {
  /**
   * Версия платформы 1С
   */
  String v8Version = "8.3"

  /**
   * Агент по умолчанию
   */
  String agent = "any"

  /**
   * Режим отладки
   */
  boolean debug = false

  /**
   * Настройка уведомлений
   */
  NotificationOptional notification = NotificationOptional.EMPTY

  /**
   * E-mail для уведомлений
   */
  String emailForNotification = UsherConstant.EMPTY_VALUE

  /**
   * Путь к общему конфигу vrunner
   */
  String vrunnerConfig = "./tools/JSON/vRunner.json"

  /**
   * Путь к каталогу с junit тестами
   */
  String junitPath = UsherConstant.JUNIT_PATH

  /**
   * Общий таймаут на задание
   */
  int timeout = 100

  /**
   * Информационная база по умолчанию
   */
  InfoBase defaultInfobase = InfoBase.EMPTY

  /**
   * Шаги задания
   */
  Stages stages = Stages.EMPTY

  @JsonProperty("gitsync")
  GitsyncOptional gitsyncOptional = GitsyncOptional.EMPTY

  @JsonProperty("edtTransform")
  EdtTransformOptional edtTransformOptional = EdtTransformOptional.EMPTY

  @JsonProperty("preparebase")
  PrepareBaseOptional prepareBaseOptional = PrepareBaseOptional.EMPTY

  @JsonProperty("syntaxCheck")
  SyntaxCheckOptional syntaxCheckOptional = SyntaxCheckOptional.EMPTY

  @JsonProperty("smoke")
  SmokeOptional smokeOptional = SmokeOptional.EMPTY

  @JsonProperty("tdd")
  TddOptional tddOptional = TddOptional.EMPTY

  @JsonProperty("bdd")
  BddOptional bddOptional = BddOptional.EMPTY

  @JsonProperty("sonarqube")
  SonarQubeOptional sonarQubeOptional = SonarQubeOptional.EMPTY

  @JsonProperty("build")
  BuildOptional buildOptional = BuildOptional.EMPTY
}
