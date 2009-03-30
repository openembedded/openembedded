from distutils.core import setup
from distutils.extension import Extension
from Cython.Distutils import build_ext

setup(
  name = 'opendir',
  version = '0.0.1',
  author = 'Gregory Ewing',
  author_email = 'greg ewing at canterbury ac nz',
  maintainer = 'Johannes "josch" Schauer',
  maintainer_email = 'j schauer at email de',
  description = 'Implements POSIX opendir',
  classifiers = [
    'Development Status :: 4 - Beta',
    'Intended Audience :: Developers',
    'Operating System :: POSIX',
    'Programming Language :: Pyrex',
    'Topic :: Software Development :: Libraries :: Python Modules',
    'Topic :: System :: Filesystems'
  ],
  ext_modules=[ 
    Extension("opendir", ["opendir.pyx"]),
    ],
  cmdclass = {'build_ext': build_ext}
)
