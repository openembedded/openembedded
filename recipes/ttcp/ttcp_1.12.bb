DESCRIPTION = "Test TCP connection."
# Makes a connection on port 5001 and transfers fabricated
# buffers or data copied from stdin.
LICENSE = "Public Domain"

# We need something to talk to on the host...
PR = "r5"

SRC_URI = "http://www.netcore.fi/pekkas/linux/ipv6/ttcp.c \
	"

S = "${WORKDIR}"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} -o ttcp ttcp.c
}

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/ttcp ${D}${bindir}/
}

# FILES_${PN} += " /usr/local/bin "
FILES_${PN} += " ${bindir}/* "

#python do_package_prepend() {
#        destdir = "%s/usr/local/bin" % (bb.data.expand('${D}', d))
#        bb.mkdirhier(destdir)
#}


SRC_URI[md5sum] = "2f6ffb3e9132f4815c3ade3bd1dba99b"
SRC_URI[sha256sum] = "52f438ef4f57ddbdd1e0dcd77efeffbdf10e59ff09279cff2fcc717803536612"
