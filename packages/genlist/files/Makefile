#CC	=	gcc
CFLAGS	=	-Wall -Os

#VERSION	=	\"V0.10\"
#CFLAGS	+=	-DVERSION=$(VERSION)

# for use with LIRC, uncomment the following two lines
# CFLAGS += -DUSELIRC
# LDFLAGS += -llirc_client

#######################################################################

SRC	=	genlist.c 
OBJ	=	genlist.o 

all:	genlist

genlist:	$(OBJ)
	$(CC) -s -o genlist $(OBJ) $(LDFLAGS)

genlist.o:	genlist.c


clean:
	rm -f $(OBJ) genlist
