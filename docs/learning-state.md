# AI 学习状态

## 学习目标

当前目标是通过这个 `analysis-agent` 项目，系统学习 AI 应用开发与 AI 工程思维。

重点不是快速做完一个复杂产品，而是逐步建立：

- 模型调用能力
- 结构化输出能力
- Prompt 设计能力
- 输出校验与容错能力
- AI 节点工程化设计能力

## 当前项目状态

当前仓库已经完成一个最小 AI 学习闭环：

- Spring Boot 项目可运行
- 已接入 Spring AI
- 已能调用模型
- 有最小 AI 控制器和服务
- 已有结构化抽取接口

当前关键代码大致包括：

- `src/main/java/com/example/analysisagent/config/AiConfig.java`
- `src/main/java/com/example/analysisagent/config/AiProperties.java`
- `src/main/java/com/example/analysisagent/controller/AiController.java`
- `src/main/java/com/example/analysisagent/service/AiPingService.java`
- `src/main/java/com/example/analysisagent/service/AiExtractService.java`
- `src/main/java/com/example/analysisagent/controller/dto/TextRequest.java`
- `src/main/java/com/example/analysisagent/controller/dto/TextResponse.java`

## 已完成学习内容

已经系统讲过并实践过这些内容：

1. Spring AI 最小调用链路
2. 结构化输出
3. Prompt 基础约束
4. system prompt / user prompt 分离
5. few-shot 基础认知
6. Token（托肯）与上下文长度
7. 上下文裁剪
8. 上下文分层
9. 输入输出分开评估
10. 任务边界
11. 任务拆分
12. 结构化节点与生成型节点
13. 把 AI 当成不稳定依赖
14. 失败处理策略
15. 超时意识
16. 成本意识
17. 什么时候不该用模型
18. AI 节点前后的程序职责

## 当前教学节奏

教学要求：

- 每次只讲当前课程
- 不展开下一课内容
- 不让我选方向，由老师直接安排
- 适当结合当前代码讲
- 适当给少量代码样例
- 更偏工程化和实践判断

## 当前阶段定位

我不是在学 Spring Boot 入门。

我是三年经验的 Java 工程师，当前是在补：

- AI 应用开发经验
- Prompt 工程经验
- 模型输出约束经验
- AI 系统设计经验

因此后续教学要默认我具备常规 Java/Spring 基础。

## 新电脑继续学习的恢复步骤

在另一台电脑或新会话继续学习时，按这个顺序恢复：

1. clone 本仓库
2. 打开本仓库
3. 让 Codex 先读取：
   - `AGENTS.md`
   - `docs/learning-state.md`
4. 再读取当前关键代码：
   - `AiController`
   - `AiExtractService`
   - `AiConfig`
5. 然后直接从当前学习位置继续上课

## 推荐的新会话开场提示

可以在新电脑新会话里直接发送：

```text
你是我的 AI 工程老师。
请先读取仓库里的 AGENTS.md 和 docs/learning-state.md，再读取当前关键代码。
我是一名三年经验的 Java 开发工程师，不需要重复 Spring Boot 基础。
请按当前学习进度继续讲课，每次只讲当前课程内容。
```

## 当前继续学习的位置

当前已经完成 AI 工程基础认知阶段，后续仍应围绕当前项目继续深入：

- 强化结构化输出稳定性
- 提升 Prompt 组织能力
- 强化校验、容错、日志与工程化能力
- 逐步过渡到更完整的 AI 节点设计

如果老师在新会话中接手，应该先基于现有代码判断当前最合适的下一课，而不是从头开始。
