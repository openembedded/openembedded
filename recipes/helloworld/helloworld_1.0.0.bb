DESCRIPTION = "Minimal statically compiled Hello world!"
LICENSE = "GPL"
PR = "r1"

S = "${WORKDIR}/${P}"

do_fetch () {
	mkdir -p ${WORKDIR}/${P}
	cd ${WORKDIR}/${P}
	printf "#include <stdio.h>\nint main(void)\n{\n\tprintf(\"Hello world!\\\n\");\twhile(1);\n\treturn 0;\n}\n" >helloworld.c
}

do_compile () {
	${CC} ${CFLAGS} -c -o helloworld.o helloworld.c
	${CC} ${LDFLAGS} -o helloworld helloworld.o -static
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 helloworld ${D}${bindir}/
	# /bin/init is on purpose, it is tried after /sbin/init and /etc/init
	# so if a sysvinit is installed, it will be used instead of helloworld
	install -d ${D}${base_bindir}
	ln -sf ${bindir}/helloworld ${D}${base_bindir}/init
}
