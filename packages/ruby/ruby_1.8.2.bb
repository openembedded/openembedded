DESCRIPTION = "Ruby is an interpreted scripting language \
for quick and easy object-oriented programming."
SECTION = "devel/ruby"
DEPENDS = "ruby-native"
PRIORITY = "optional"
MAINTAINER = "Gints Polis <gints.polis@cc.lv>"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.ruby-lang.org/pub/ruby/ruby-${PV}.tar.gz"
S = "${WORKDIR}/ruby-${PV}"

inherit autotools
