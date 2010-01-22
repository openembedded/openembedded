require wxwidgets-${PV}.inc

DEPENDS += "virtual/libgl"

PR = "${INC_PR}.0"

EXTRA_OECONF += "--with-opengl"
