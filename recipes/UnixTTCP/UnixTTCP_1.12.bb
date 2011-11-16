DESCRIPTION = "Test TCP connection."
# Makes a connection on port 5001 and transfers fabricated
# buffers or data copied from stdin.
LICENSE = "Public Domain"

PR = "r0"
PN = "unixttcp"

SRC_URI = "http://www.pcausa.com/Utilities/pcattcp/UnixTTCP.zip \
	"
S = "${WORKDIR}/UnixTTCP"

do_compile () {
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} -o ttcp ttcp.c
}

do_stage() {
	install -d ~/bin
	install -m 0755 ${S}/ttcp ~/bin
}

# Wrong Checksums for now.
SRC_URI[md5sum] = "4061bf263cdd6bbccacedcca9b6370aa"
SRC_URI[sha256sum] = "d209f58b6765c0eb0ee2e7cf27b9cd4bdaab861ae9adab9f9367700552423847"
