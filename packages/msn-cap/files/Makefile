#CC	=	gcc
CFLAGS	=	-Wall -Os

#VERSION	=	\"V0.10\"
#CFLAGS	+=	-DVERSION=$(VERSION)

# for use with LIRC, uncomment the following two lines
# CFLAGS += -DUSELIRC
# LDFLAGS += -llirc_client

#######################################################################

SRC	=	msn-cap.c 
OBJ	=	msn-cap.o 

all:	msn-cap

msn-cap:	$(OBJ)
	$(CC) -s -o msn-cap $(OBJ) $(LDFLAGS)

msn-cap.o:	msn-cap.c


clean:
	rm -f $(OBJ) msn-cap
