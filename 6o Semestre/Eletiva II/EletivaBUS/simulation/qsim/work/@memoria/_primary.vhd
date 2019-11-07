library verilog;
use verilog.vl_types.all;
entity Memoria is
    port(
        Out_Bit0        : out    vl_logic;
        Sel_1           : in     vl_logic;
        Sel_0           : in     vl_logic;
        Mem_Write       : in     vl_logic;
        Bit_0           : in     vl_logic;
        Bit_1           : in     vl_logic;
        Bit_2           : in     vl_logic;
        Bit_3           : in     vl_logic;
        mem_read        : in     vl_logic;
        Out_Bit1        : out    vl_logic;
        Out_Bit2        : out    vl_logic;
        Out_Bit3        : out    vl_logic
    );
end Memoria;
