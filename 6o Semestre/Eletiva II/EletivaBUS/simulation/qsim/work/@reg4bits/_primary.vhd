library verilog;
use verilog.vl_types.all;
entity Reg4bits is
    port(
        OUT_0           : out    vl_logic;
        CLOCK           : in     vl_logic;
        IN_0            : in     vl_logic;
        OUT_1           : out    vl_logic;
        IN_1            : in     vl_logic;
        OUT_2           : out    vl_logic;
        IN_2            : in     vl_logic;
        OUT_3           : out    vl_logic;
        IN_3            : in     vl_logic
    );
end Reg4bits;
