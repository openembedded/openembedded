DESCRIPTION = "Objective Caml Compiler"
SECTION = "devel"
LICENSE = "QPL"

SRC_URI = "http://caml.inria.fr/distrib/ocaml-${PV}/ocaml-${PV}.tar.gz"
S = "${WORKDIR}/ocaml-${PV}"

inherit autotools native

SRC_URI[md5sum] = "51530ed183b511ce19fed325c8ab1b43"
SRC_URI[sha256sum] = "1509bde867515d7e7b51710f2b0d2efe0ab5e5918d475244882e615d970b729a"
