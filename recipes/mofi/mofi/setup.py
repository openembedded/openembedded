from distutils.core import setup

import os

setup(
    name = "Mofi",
    version = "0.02",
    author = "The Mofi Team",
    author_email = "NA",
    url = "http://projects.openmoko.org/projects/mofi/",
    packages = ["settingsgui"],
    scripts = ['mofi_gui.py', 'mofi.py'],
)
