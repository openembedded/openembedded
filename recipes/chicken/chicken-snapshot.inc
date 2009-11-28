ESCRIPTION = "A compiler that translates Scheme source files to C, and an interpreter"
HOMEPAGE = "http://www.call-with-current-continuation.org/"
SECTION = "interpreters"
PRIORITY = "optional"
LICENSE = "BSD"
INC_PR = "r3"

SRC_URI = "http://chicken.wiki.br/dev-snapshots/2009/11/24/chicken-${PV}.tar.gz"

# Parallel building is not supported
PARALLEL_MAKE = ""

inherit chicken
