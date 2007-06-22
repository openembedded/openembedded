inherit native
require jikes_${PV}.bb

PROVIDES = "virtual/javac-native"
S = "${WORKDIR}/jikes-${PV}"

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 755 src/jikes ${STAGING_BINDIR}
}
