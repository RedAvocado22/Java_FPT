USE [master]
GO
Create database Y24SU1B5
GO
USE Y24SU1B5
GO

CREATE TABLE [dbo].[Types](
	[TypeID] [int] NOT NULL PRIMARY KEY,
	[TypeName] [varchar](max) NOT NULL
)
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
insert into [Types] values(1,'Sub First')
insert into [Types] values(2,'Sub Last')
GO

CREATE TABLE [dbo].[Executions](
	[ExecutionID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[InputString] [varchar](max) NOT NULL,
	[SubIndex] [int] NOT NULL,
	[Result] [varchar](max) NOT NULL,
	[TypeID] int references [Types]([TypeID])
)
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
insert into [Executions]([InputString],[SubIndex],[Result],[TypeID]) values('FPT University',2,'FPT',1)
insert into [Executions]([InputString],[SubIndex],[Result],[TypeID]) values('FPT University',4,'University',2)
insert into [Executions]([InputString],[SubIndex],[Result],[TypeID]) values('Computing Fundamental',8,'Computing',1)
insert into [Executions]([InputString],[SubIndex],[Result],[TypeID]) values('Computing Fundamental',10,'Fundamental',2)
insert into [Executions]([InputString],[SubIndex],[Result],[TypeID]) values('FPT University',6,'versity',2)
GO