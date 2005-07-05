# The Boost web site provides free peer-reviewed portable
# C++ source libraries. The emphasis is on libraries which
# work well with the C++ Standard Library. The libraries are
# intended to be widely useful, and are in regular use by
# thousands of programmers across a broad spectrum of applications.
DESCRIPTION = "Make system for boost (native)"
HOMEPAGE = "http://www.boost.org/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "Boost Software License"

SRC_URI = "http://download.sourceforge.net/boost/boost-jam-${PV}.tgz"

inherit native

S = "${WORKDIR}/boost-jam-${PV}"

do_compile() {
	set -ex
	rm -rf bin.*
	./build.sh gcc
}

# This is too terrible - the build script doesn't give any good
# way I can see to find out where the binaries are placed, so
# rely on only one bin.foo directory being created.
do_stage() {
	set -ex
	install -c -m 755 bin.*/jam ${bindir}
	install -c -m 755 bin.*/mkjambase ${bindir}
	install -c -m 755 bin.*/yyacc ${bindir}
	rm -f ${bindir}/bjam
	ln ${bindir}/jam ${bindir}/bjam
}
