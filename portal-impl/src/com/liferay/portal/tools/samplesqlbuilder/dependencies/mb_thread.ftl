<#setting number_format = "0">

insert into MBThread values (${mbThread.threadId}, ${mbThread.groupId}, ${mbThread.companyId}, ${mbThread.categoryId}, ${mbThread.rootMessageId}, ${mbThread.rootMessageUserId}, ${mbThread.messageCount}, 0, FALSE, ${mbThread.lastPostByUserId}, CURRENT_TIMESTAMP, 0, 0, ${mbThread.lastPostByUserId}, '', CURRENT_TIMESTAMP);