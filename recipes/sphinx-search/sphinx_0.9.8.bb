DESCRIPTION = "The Sphinx Fulltext Indexer"
HOMEPAGE = "http://www.sphinxsearch.com/"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "expat"

SRC_URI = "\
  http://www.sphinxsearch.com/downloads/sphinx-${PV}.tar.gz \
  http://snowball.tartarus.org/dist/libstemmer_c.tgz \
"

inherit autotools

EXTRA_OECONF = "\
  --without-mysql \
  --with-libstemmer \
"

# miscompiles w/ O2
FULL_OPTIMIZATION_arm = "-O1"

inherit autotools

do_configure_prepend() {
	mv ${WORKDIR}/libstemmer_c/* libstemmer_c/
}
