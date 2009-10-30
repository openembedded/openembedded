DESCRIPTION = "Flex is a tool for generating programs that recognize lexical patterns in text."
SECTION = "devel"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/flex/flex-2.5.31.tar.bz2 \
           file://flex-lvalue.diff;patch=1 \
           file://fix-gen.patch;patch=1"
S = "${WORKDIR}/flex-${PV}"

inherit autotools

# >> flex-2.5.31-r4: /usr/lib/libfl.a
# That one is a special case: it wants to stay in the main flex package,
# since flex itself is a development tool.  I'm not sure why it is a
# static-only library; that might be an error

FILES_${PN} += "${libdir}/libfl.a"
