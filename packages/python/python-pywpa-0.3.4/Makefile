# Simple Makefile

NAME    = pywpa/_pywpa
CFLAGS += -Iwpactrl
OBJS    = pywpa.o

%.o: %.c
	@echo "Compiling $(<)"
	@$(CC) $(CFLAGS) -c $(<) -o $(@)

$(NAME).so: objects libwpactrl
	@echo "Statically Linking $(NAME)"
	@$(CC) $(CFLAGS) $(OBJS) wpactrl/wpa_ctrl.o -shared -o $(NAME).so

main: objects libwpactrl
	@echo "Creating test"
	@$(CC) $(CFLAGS) $(OBJS) wpactrl/wpa_ctrl.o -o test -lpython2.4

objects: $(OBJS)

libwpactrl:
	@make -C wpactrl > /dev/null

clean:
	@rm -rf *.o
	@rm -rf $(NAME).so
	@rm -rf $(NAME).so.t*
	@make -C wpactrl clean 2>/dev/null
