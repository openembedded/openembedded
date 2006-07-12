DESCRIPTION = "PyEphem provides scientific-grade astronomical computations \
for the Python programming language. \
Given a date and location on the Earth's surface, it can compute the positions \
of the Sun and Moon, of the planets and their moons, and of any asteroids, \
comets, or earth satellites whose orbital elements the user can provide."
HOMEPAGE = "http://www.rhodesmill.org/brandon/projects/pyephem.html"
LICENSE = "PSF"
AUTHOR = "Brandon Craig Rhodes"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "ml0"

SRC_URI = "http://www.rhodesmill.org/brandon/projects/pyephem-${PV}.tar.gz"
S = "${WORKDIR}/pyephem-${PV}"

inherit distutils

