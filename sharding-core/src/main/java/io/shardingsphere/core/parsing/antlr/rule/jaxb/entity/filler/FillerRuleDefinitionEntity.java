/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.antlr.rule.jaxb.entity.filler;

import io.shardingsphere.core.parsing.antlr.rule.jaxb.entity.RuleDefinitionEntity;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Filler rule definition entity for JAXB.
 *
 * @author zhangliang
 */
@XmlRootElement(name = "filler-rule-definition")
@Getter
public final class FillerRuleDefinitionEntity implements RuleDefinitionEntity {
    
    @XmlAttribute(name = "sql-segment-base-package", required = true)
    private String sqlSegmentBasePackage;
    
    @XmlAttribute(name = "filler-base-package", required = true)
    private String fillerBasePackage;
    
    @XmlElement(name = "filler-rule")
    private Collection<FillerRuleEntity> rules = new LinkedList<>();
}
