DESCRIPTION = "Etox is a type setting and text layout library based on Evas. \
Etox helps you when it comes to displaying, moving, resizing, layering, \
clipping, aligning and coloring fonts in different styles, and more."
DEPENDS = "edb virtual/evas virtual/ecore"
LICENSE = "MIT"
PR = "r1"

inherit efl

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/etox;date=${PV}"
S = "${WORKDIR}/etox"

libdirectory = "src"
