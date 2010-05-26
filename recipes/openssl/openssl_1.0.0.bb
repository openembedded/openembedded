inherit pkgconfig

require openssl.inc
SRC_URI[src.md5sum] = "89eaa86e25b2845f920ec00ae4c864ed"
SRC_URI[src.sha256sum] = "1bbf9afc5a6215121ac094147d0a84178294fe4c3d0a231731038fd3717ba7ca"

PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

export DIRS = "crypto ssl apps engines"
export OE_LDFLAGS="${LDFLAGS}"

SRC_URI += "file://configure-targets.patch \
            file://shared-libs.patch \
            file://debian.patch \
            file://oe-ldflags.patch \
	    file://libdeps-first.patch \
	    file://engines-install-in-libdir-ssl.patch \
	   "

PARALLEL_MAKE = ""

PACKAGES += " \
	${PN}-engines \
	${PN}-engines-dbg \
	"

FILES_${PN}-engines = "${libdir}/ssl/engines/*.so"
FILES_${PN}-engines-dbg = "${libdir}/ssl/engines/.debug"
