DESCRIPTION="A Window Matching utility similar to Sawfish's 'Matched Windows' feature"
HOMEPAGE="http://www.burtonini.com/blog/computers/devilspie"

SRC_URI="http://www.burtonini.com/computing/${P}.tar.gz"

LICENSE="GPL"

inherit pkgconfig autotools

PR = "r0"

DEPENDS="intltool gettext"
RDEPENDS="glib-2.0 gtk+ libwnck"

SRC_URI[md5sum] = "4190e12f99ab92c0427e457d9fbfe231"
SRC_URI[sha256sum] = "e06aba1d96889e1b58bd1b0ba4d3015f50adc3ade2824b5cb37a0ee7f2490aaf"
