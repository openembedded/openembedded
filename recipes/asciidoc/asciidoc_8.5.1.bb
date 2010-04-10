DESCRIPTION = "AsciiDoc is a text document format for writing short documents, articles, books and UNIX man pages."
HOMEPAGE = "http://www.methods.co.nz/asciidoc/"
LICENSE = "GPLv2"

SRC_URI = "http://mesh.dl.sourceforge.net/project/asciidoc/asciidoc/${PV}/asciidoc-${PV}.tar.gz"

inherit distutils-base autotools_stage pkgconfig

export vimdir = "${D}${sysconfdir}/vim"
export DESTDIR = "${D}"

do_install() {
	sed -i -e s:/etc/vim::g ${S}/Makefile
	oe_runmake -e install
}

FILES_${PN} += "${sysconfdir}"

# TODO: only depend on codecs, csv, doctest, fnmatch, getopt, HTMLParser, locale, optparse, os, re, shutil, StringIO, subprocess, sys, tempfile, time, traceback, urlparse, zipfile
RDEPENDS_${PN} += "python-modules"

SRC_URI[md5sum] = "412fb0c86c3dcb4cc159ef63bd274c90"
SRC_URI[sha256sum] = "ccb02db04e6e6eff2149435516e88557ca30c85bc4467420f40c895e25f17a20"
