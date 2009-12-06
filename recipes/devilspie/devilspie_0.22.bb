DESCRIPTION="A Window Matching utility similar to Sawfish's 'Matched Windows' feature"
HOMEPAGE="http://www.burtonini.com/blog/computers/devilspie"

SRC_URI="http://www.burtonini.com/computing/${P}.tar.gz"

LICENSE="GPL"

inherit pkgconfig autotools

PR = "r0"

DEPENDS="intltool gettext"
RDEPENDS="glib-2.0 gtk+ libwnck"
