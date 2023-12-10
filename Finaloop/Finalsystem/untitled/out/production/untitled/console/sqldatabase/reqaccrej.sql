create table Accept(acceptID Serial Primary Key,
			  reqida int,
				accept_ Varchar(30)	
				   );
create table Reject(rejectID Serial Primary Key,
					reqidr INT,
				   reject_ Varchar(255)
				   );
Insert into Accept(accept_,reqida) values ('Your Request has been Approved','1') ;
Insert into Reject(reject_,reqidr) values ('Your Request has been Rejected','1');
Select * from Accept;
Select * from Reject;


