SECTION = "console/network"
include postfix_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/postfix-${PV}"
DEPENDS = "virtual/db-native pcre-native"
export DIRS = "src/util src/global src/postconf"

do_stage () {
	install -m 0755 src/postconf/postconf ${STAGING_BINDIR}/
}
