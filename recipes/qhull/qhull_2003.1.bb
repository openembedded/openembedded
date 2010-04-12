DESCRIPTION = "Qhull computes the convex hull, Delaunay triangulation, Voronoi diagram, halfspace intersection about a point, furthest-site Delaunay triangulation, and furthest-site Voronoi diagram. "
LICENSE = "unknown"

SRC_URI = "http://www.qhull.org/download/qhull-${PV}.tar.gz"

inherit autotools_stage lib_package





SRC_URI[md5sum] = "48228e26422bff85ef1f45df5b6e3314"
SRC_URI[sha256sum] = "68725c96603a426da748d38d0f83e7a9dd6a0bfc483525debe04001846475b0b"
