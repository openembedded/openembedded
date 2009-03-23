# *  Copyright(C) 2007 Neuros Technology International LLC. 
# *               <www.neurostechnology.com>
# *
# *  ubootcmd application make file..............TQ 2007-02-05


# include system config 
include config


# executable name
NT_PACKET     := packet_osd2


# project directories
PACKET_DIR_ROOT   := .

# compiler flags
CFLAGS         += $(DEFINES) -Wall -Werror

# object files
OBJS           := package.o crc32.o

# build all
.PHONY: all
all: $(NT_PACKET)

$(NT_PACKET): $(OBJS)
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $(OBJS)

# install
install: $(NT_PACKET)
	@echo
	@echo "Installing $(NT_PACKET) ... "
	@cp $(NT_PACKET) $(BSP_ROOT)/images/
	@echo

# clean up project
.PHONY: clean

clean:
	@echo
	@rm -f $(NT_PACKET)
	@for dir in  $(PACKET_DIR_ROOT); do \
		echo "Entering $$dir ..."; \
		for file in $$dir/*~ $$dir/*.o $$dir/*.d; do \
			if [ -f $$file ]; then \
				echo "removing $$file"; \
				rm $$file; \
			fi; \
		done; \
	done
	@echo

# include the C include dependencies
-include $(OBJS:.o=.d)


# calculate C inlcude dependencies
%.d: %.c
	@set -e; rm -f $@; \
	$(CC) -MM $(CFLAGS) $< > $@.$$$$; \
	sed 's,\($*\)\.o[ :]*,\1.o $@ : ,g' < $@.$$$$ > $@; \
	rm -f $@.$$$$


# include make rules. 
include Makefile.rules
