DESCRIPTION = "Objective Caml Compiler"
SECTION = "devel"
LICENSE = "QPL"

SRC_URI = "http://caml.inria.fr/distrib/ocaml-${PV}/ocaml-${PV}.tar.gz"
S = "${WORKDIR}/ocaml-${PV}"

inherit autotools native
