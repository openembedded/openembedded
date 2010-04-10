SECTION = "base"
require e2tools_${PV}.bb
inherit native

DEPENDS = "e2fsprogs-native"
PACKAGES = ""

e2links = "e2ln e2ls e2mkdir e2mv e2rm e2tail"
do_stage () {
	install -m 0755 e2cp ${STAGING_BINDIR}/
	for i in ${e2links}; do
		ln -sf e2cp ${STAGING_BINDIR}/$i
	done
}

SRC_URI[md5sum] = "1829b2b261e0e0d07566066769b5b28b"
SRC_URI[sha256sum] = "4e3c8e17786ccc03fc9fb4145724edf332bb50e1b3c91b6f33e0e3a54861949b"
