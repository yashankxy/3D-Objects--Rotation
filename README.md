# 3D Objects -Rotation
 
In computer graphics, an object is usually represented by dividing its surface into a set of polygons
(also called faces). Such set is called a mesh.
Graphical elements such as vertices, polygons, and meshes can be transformed (e.g. translated,
rotated, etc.) using transformation matrices. For example, to rotate a vertex š£ = (š£š„, š£š¦, š£š§) about
the x-axis with angle Īø, we can multiply the following matrix by the column vector representing š£:
šš„
(š) = [
1 0 0
0 ššš š āš ššš
0 š ššš ššš š
]
That is, š£ would be transformed into š£ā² = [
        1 0 0
        0 ššš š āš ššš
        0 š ššš ššš š
][
š£š„
š£š¦
š£š§
] = [
š£š„
š£š¦ššš š ā š£š§š ššš
š£š¦š ššš + š£š§ššš š
]
Similarly, the following matrices can be used to rotate š£ about the y-axis and the z-axis respectively:
šš¦(š) = [
ššš š 0 š ššš
0 1 0
āš ššš 0 ššš š
] 
šš§(š) = [
ššš š āš ššš 0
š ššš ššš š 0
0 0 1
]

Several file formats can be used to represent meshes: OBJ, PLY, STL, FBX, etc. In this, we
will only target the OBJ and PLY formats.
OBJ format
The OBJ files to be considered consist of two consecutive sets of lines: the first set (lines starting with
a āvā) represents the unique vertices contained in the mesh and the second set (lines starting with an
āfā) represents the faces of the mesh. For example, the mesh below contains two polygons: the first
includes the vertices defined at lines 1, 2, and 3 and the second includes the vertices defined at lines
2, 3, and 4.
PLY format
The PLY format is similar to OBJ except for the following:
- It has a header that specifies different aspects including the number of vertices and the
number of faces. You can assume that the highlighted parts are fixed.
- The lines representing the vertices do not start with a āvā.
- The lines representing the faces do not start with an āfā. Instead, they start with the number
of vertices included in the corresponding face.
- Vertex indexing starts at 0 instead of 1. That is, the first line containing a vertex is labelled 0.
v 5.1 1.2 0.3
v 4.9 1.5 0.3
v 3.8 1.4 0.5
v 4.1 1.6 0.6
f 1 2 3
f 2 3 4 
ply
format ascii 1.0
element vertex 4
property float32 x
property float32 y
property float32 z
element face 2
property list uint8 int32 vertex_indices
end_header
5.1 1.2 0.3
4.9 1.5 0.3
3.8 1.4 0.5
4.1 1.6 0.6
3 0 1 2
3 1 2 3