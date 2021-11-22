/*
 * Vanessa-Usher
 * Copyright (C) 2019-2021 SilverBulleters, LLC - All Rights Reserved.
 * Unauthorized copying of this file in any way is strictly prohibited.
 * Proprietary and confidential.
 */
import org.silverbulleters.usher.config.ConfigurationReader
import org.silverbulleters.usher.config.PipelineConfiguration

/**
 * Конфигурация конвейера из файла
 *
 * @param pathToConfig путь к конфигурации
 * @return
 */
PipelineConfiguration call(String pathToConfig) {

  if (fileExists(pathToConfig)) {
    def content = readFile(pathToConfig)
    return ConfigurationReader.create(content)
  } else {
    throw new Exception("Конфигурационный файл не найден")
  }
}

/**
 * Конфигурация конвейера по умолчанию
 * 
 */
PipelineConfiguration call() {
  return ConfigurationReader.create()
}
