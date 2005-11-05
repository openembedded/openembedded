DESCRIPTION = "Hmm is a python module providing an implementation of Hidden Markov \
Model and associated algorithms (Viterbi and Baum-Welsh). It uses Numeric \
Python to speed up the computations."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "python-numeric"
DEPENDS = "python-numeric"
SRCNAME = "hmm"

SRC_URI = "ftp://ftp.logilab.org/pub/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

