import styled from "styled-components";

const SubscribeMark = () => {
  return (
    <Layout>
          <svg
      background='new 0 0 64 64'
      viewBox='0 0 64 64'
    >
      <path
        d='M63.792,56.915c0,3.798-3.079,6.876-6.875,6.876H6.875C3.08,63.791,0,60.713,0,56.915V6.875   C0,3.08,3.08,0,6.875,0h50.042c3.796,0,6.875,3.08,6.875,6.875V56.915z'
        fill='#37b34a'
      />
      <path
        d='m53.867 14.14c-1.956-1.669-4.894-1.439-6.562.514l-20.04 23.437-10.781-9c-1.802-1.505-4.482-1.264-5.985.536-1.504 1.8-1.262 4.48.538 5.983l14.444 12.06c.938.783 2.111 1.083 3.235.946 1.188-.093 2.341-.639 3.179-1.616l22.483-26.3c1.668-1.954 1.436-4.891-.515-6.562'
        fill='#f4f4f4'
      />
    </svg>
    </Layout>
  );
};
const Layout = styled.div`
  position: absolute;
  left:2.75%;
  top:2.75%;
  margin:5.5%;
  width:11%;
  height:11%;
`

export default SubscribeMark;
