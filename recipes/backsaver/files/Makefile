backsaver: backsaver.o

backsaver.o: backsaver.c

install:
	install -d ${prefix}/usr/bin/
	# Needs to be installed suid to access sysfs & dev/input
	install -m 4755 backsaver ${prefix}/usr/bin/
