DESCRIPTION = "Ragel State Machine Compiler"
HOMEPAGE = "http://www.complang.org/ragel/"
LICENSE = "GPL"

SRC_URI = "http://www.complang.org/ragel/ragel-${PV}.tar.gz;name=tar"
SRC_URI[tar.md5sum] = "5c4366369f4934adc02bd71dc1a4ee1f"
SRC_URI[tar.sha256sum] = "a8f38166d57163ff821ad4608ba258ed3b01ac8abb890440e03163cbb835e932"

inherit autotools
inherit native