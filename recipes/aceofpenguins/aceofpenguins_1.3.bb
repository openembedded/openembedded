DESCRIPTION = "The Ace of Penguins is a set of Unix/X solitaire games based on the ones available for Windows(tm) but with a number of enhancements that my wife says make my versions better :-) \
The latest version includes clones of freecell, golf, mastermind, merlin, minesweeper, pegged, solitaire, taipei (with editor!), and thornq (by Martin Thornquist)."
AUTHOR = "dj@delorie.com"
HOMEPAGE = "http://www.delorie.com/store/ace/"
SECTION = "games"
DEPENDS = "libpng-native libpng zlib-native libxpm"
PR = "r1"

SRC_URI = "\
  http://www.delorie.com/store/ace/ace-${PV}.tar.gz\
  file://fix-crosscompile.patch\
"
SRC_URI[md5sum] = "1bd11ed270342ad78ff4822c06c6a762"
SRC_URI[sha256sum] = "4fb6ca9e1ff34e42d9498f06e2bccaa61f5650daf48774015468d5f75c5347d3"

S = "${WORKDIR}/ace-${PV}"

inherit autotools
