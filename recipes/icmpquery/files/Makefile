#CC	=	gcc
CFLAGS	=	-Wall -Os

#VERSION	=	\"V0.10\"
#CFLAGS	+=	-DVERSION=$(VERSION)

# for use with LIRC, uncomment the following two lines
# CFLAGS += -DUSELIRC
# LDFLAGS += -llirc_client

#######################################################################

SRC	=	icmpquery.c 
OBJ	=	icmpquery.o 

all:	icmpquery

icmpquery:	$(OBJ)
	$(CC) -s -o icmpquery $(OBJ) $(LDFLAGS)

icmpquery.o:	icmpquery.c


clean:
	rm -f $(OBJ) icmpquery
