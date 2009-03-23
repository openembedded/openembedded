# Simple Makfile

NAME   = pyiw
LIBS  += -liw

#static: pyiw.c
#	@echo "Statically Building/Linking $(NAME)"
#	@$(CC) $(CFLAGS) -Istaticlibiw $(<) -shared -o $(NAME).so staticlibiw/libiw.a

dynamic: pyiw.c
	@echo "Dynamically Building/Linking $(NAME)"
	@$(CC) $(CFLAGS) $(LDFLAGS) $(LIBS) $(<) -shared -o $(NAME).so

clean:
	@rm -rf *.o
	@rm -rf $(NAME).so
	@rm -rf $(NAME).so.t*

